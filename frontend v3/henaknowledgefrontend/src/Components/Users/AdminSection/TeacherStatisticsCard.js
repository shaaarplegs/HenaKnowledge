import React, { useState, useEffect } from "react";
import axios from "axios";
import "./StudentStatisticsCard.css";
import { Bar } from "react-chartjs-2";
import Popup from "reactjs-popup";
import "reactjs-popup/dist/index.css";
import TeacherIcon from "../../../Assets/teacherIcon";

const TeacherStatisticsCard = (props) => {
  const [teacher, setteacher] = useState({});
  const [isLoading, SetisLoading] = useState(false);
  const [AmountOfAnsweredQuestions, SetAmountOfAnsweredQuestions] = useState(0);
  const [AmountOfSharedExperiences, setAmountOfSharedExperiences] = useState(0);
  const chartDataPoints = {
    labels: ["Amount Of Answered Questions", "Amount Of Shared Experiences"],
    datasets: [
      {
        label: teacher.firstName + " " + teacher.lastName + " activity",
        data: [AmountOfAnsweredQuestions, AmountOfSharedExperiences],
      },
    ],
  };
  useEffect(() => {
    SetisLoading(true);
    axios
      .get(`http://localhost:8080/Teacher/${props.teacherID}`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        SetisLoading(false);
        setteacher(res.data);
        axios
          .get(
            `http://localhost:8080/Admin/getAmountOfSharedExperienceByTeacher?teacherID=${props.teacherID}`,
            {
              headers: {
                Authorization: `Bearer ${localStorage.getItem("jwt")}`,
              },
            }
          )
          .then((sharedexperiencesRes) => {
            setAmountOfSharedExperiences(sharedexperiencesRes.data);

            axios
              .get(
                `http://localhost:8080/Admin/getAmountOfAskedQuestionsByTeacher?teacherID=${props.teacherID}`,
                {
                  headers: {
                    Authorization: `Bearer ${localStorage.getItem("jwt")}`,
                  },
                }
              )
              .then((answeredQuestionsRes) => {
                SetAmountOfAnsweredQuestions(answeredQuestionsRes.data);
              });
          })
          .catch((error) => {
            SetisLoading(false);
            console.log(error.response);
          });
      });
  }, []);

  return (
    <div>
      {isLoading && <p>Loading...</p>}
      {!isLoading && (
        <div class="card">
          <div class="img-avatar">
            <TeacherIcon />
          </div>
          <div class="card-text">
            <div class="portada"></div>
            <div class="title-total">
              <div class="title">Teacher</div>
              <h2>
                {teacher.firstName} {teacher.lastName}
              </h2>

              <div class="desc">
                <div>
                  <h4>email name: {teacher.email}</h4>
                  <h4>specialization : {teacher.specialization}</h4>
                  <br></br>
                </div>
              </div>
              <div class="actions">
                <Popup trigger={<button>Show statistics</button>} modal nested>
                  <div>
                    <Bar data={chartDataPoints} />
                  </div>
                </Popup>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};
export default TeacherStatisticsCard;
