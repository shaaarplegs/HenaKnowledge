import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import axios from "axios";
// import "./StudentContact.css";

const TeacherContact = (props) => {
  const param = useParams();
  const [isLoading, SetisLoading] = useState(false);
  const [answer, setAnswer] = useState("");
  const [contactInfo, setcontactInfo] = useState({});

  useEffect(() => {
    SetisLoading(true);
    axios
      .get(
        `http://localhost:8080/ContactInfo/getContactInfo?ID=${param.contactID}`,
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("jwt")}`,
          },
        }
      )
      .then((res) => {
        SetisLoading(false);
        setcontactInfo(res.data);
      })
      .catch((error) => {
        SetisLoading(false);
      });
  }, []);

  const ChangeAnswerHandler = (e) => {
    setAnswer(e.target.value);
  };
  const AnswerQuestionHandler = (e) => {
    let updatedContact;
    updatedContact = {
      id: contactInfo.id,
      studentQuestion: contactInfo.studentQuestion,
      teacherResponse: answer,
      pending: 0,
      wasUseful: 0,
      wasNotUseful: 0,
      studentID: contactInfo.studentID,
      teacherID: contactInfo.teacherID,
    };

    axios.put("http://localhost:8080/ContactInfo", updatedContact, {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
    });

    window.location.reload(true);
  };

  return (
    <div>
      {isLoading && <p>obtaining data...</p>}
      {!isLoading && (
        <div>
          Student question :
          <div className="question">
            <p>{contactInfo.studentQuestion}</p>
          </div>
          {contactInfo.wasUseful === 0 &&
            contactInfo.wasNotUseful === 0 &&
            contactInfo.teacherResponse === "" && (
              <div>
                Send answer :
                <div className="response">
                  <textarea
                    value={answer}
                    onChange={ChangeAnswerHandler}
                  ></textarea>
                </div>
                <button onClick={AnswerQuestionHandler}>Send answer</button>
              </div>
            )}
          {contactInfo.wasNotUseful === 1 && (
            <div>
              Your response :
              <div className="response">
                <textarea
                  readOnly
                  value={contactInfo.teacherResponse}
                ></textarea>
              </div>
            </div>
          )}
          {contactInfo.wasUseful === 1 && (
            <div>
              Your response :
              <div className="response">
                <textarea
                  readOnly
                  value={contactInfo.teacherResponse}
                ></textarea>
              </div>
            </div>
          )}
          Student opinion about your answer:{" "}
          {contactInfo.wasUseful === 1 && <h1>The answer was useful.</h1>}
          {contactInfo.wasNotUseful === 1 && (
            <h1>The answer was not useful.</h1>
          )}
          {contactInfo.wasNotUseful === 0 && contactInfo.wasUseful === 0 && (
            <h1>
              The student has not yet indicated whether the answer was useful or
              not.
            </h1>
          )}
        </div>
      )}
    </div>
  );
};

export default TeacherContact;
