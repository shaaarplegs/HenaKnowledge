import React, { useState, useEffect } from "react";
import axios from "axios";
import Popup from "reactjs-popup";
import "reactjs-popup/dist/index.css";
import Results from '../../Utility/Results';

const StudentContactInfo = (props) => {
  const [studentQuestion, setstudentQuestion] = useState('');
  const [isSent, SetisSent] = useState(undefined);

  const onChangestudentQuestionHandler = (e) => {
    setstudentQuestion(e.target.value);
  };

  const sendQuestionHandler = (e) => {

    let ContactInfoDTO;
    ContactInfoDTO = {
      studentID: localStorage.getItem("personID"),
      teacherID: props.teacherID,
      pending: 1,
      wasUseful: 0,
      wasNotUseful: 0,
      studentQuestion: studentQuestion,
      teacherResponse: "",
    };
    console.log(ContactInfoDTO)
    axios.post("http://localhost:8080/ContactInfo/add", ContactInfoDTO, {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
    }).then((res)=>{
      SetisSent(true)
    });


  };
  return (
    <div>
      <h1>Specify your question: </h1>
      <textarea
        placeholder="type here..."
        onChange={onChangestudentQuestionHandler}
        value={studentQuestion}
      />
      <button onClick={sendQuestionHandler}>Send question</button>
      {isSent && (
            <Results
              Results={isSent}
              successMsg="Question has been sent"
            />
          )}
    </div>
    
  );
};

export default StudentContactInfo;
