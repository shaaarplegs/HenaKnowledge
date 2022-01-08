import React, { useState, useEffect } from "react";
import axios from "axios";
import "./StudentStatisticsCard.css";
import { Bar } from "react-chartjs-2";
import Popup from "reactjs-popup";
import "reactjs-popup/dist/index.css";
import StudentIcon from "../../../Assets/studentIcon";

const StudentStatisticsCard = (props) => {

  const [student, setStudent] = useState({});
  const [isLoading, SetisLoading] = useState(false);
  const [AmountOfAskedQuestions, SetAmountOfAskedQuestions] = useState(0);
  const [AmountOfSharedExperiences, setAmountOfSharedExperiences] = useState(0);
  const chartDataPoints = {
    labels: ["Amount Of Asked Questions", "Amount Of Shared Experiences"],
    datasets: [
      {
        label: student.firstName + " " + student.lastName + " activity",
        data: [AmountOfAskedQuestions, AmountOfSharedExperiences],
      },
    ],
  };
  useEffect(() => {
    SetisLoading(true);
    axios
      .get(`http://localhost:8080/Student/${props.studentID}`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        
        SetisLoading(false);
        setStudent(res.data);
        console.log(student)
        axios
          .get(
            `http://localhost:8080/Admin/getAmountOfSharedExperienceByStudent?studentID=${props.studentID}`,
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
                `http://localhost:8080/Admin/getAmountOfAskedQuestionsByStudent?studentID=${props.studentID}`,
                {
                  headers: {
                    Authorization: `Bearer ${localStorage.getItem("jwt")}`,
                  },
                }
              )
              .then((askedQuestionsRes) => {
                SetAmountOfAskedQuestions(askedQuestionsRes.data);
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
            <StudentIcon />
          </div>
          <div class="card-text">
            <div class="portada"></div>
            <div class="title-total">
              <div class="title">Student</div>
              <h2>
                {student.firstName} {student.lastName}
              </h2>

              <div class="desc">
                <div>
                  <h4>email name: {student.email}</h4>
                  <h4>specialization : {student.specialization}</h4>
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
export default StudentStatisticsCard;
