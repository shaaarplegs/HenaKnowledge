import axios from "axios";
import React, { useState } from "react";
import Results from "../../Utility/Results";
import Logo from "../../../Logo/Logo";

import Popup from "reactjs-popup";
import "reactjs-popup/dist/index.css";

// const headers = {
//   "Content-Type": "application/json",
//   'Authorization': "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBRE1JTiIsImlhdCI6MTYyMTE3MTY4NSwiZXhwIjoxNjIyMDM1Njg1fQ.jV3Rw_o6mz-vMjLfVL6NRL1BJx7pA-S5GJwaFi58pT4"
// };

function AdminSignUpStudent() {
  const initialState = "";
  const [firstName, setfirstName] = useState(initialState);
  const [lastName, setlastName] = useState(initialState);
  const [dateOfBirth, setdateOfBirth] = useState(initialState);
  const [email, setemail] = useState(initialState);
  const [specialization, setspecialization] = useState(initialState);

  const [respondStatus, SetrespondStatus] = useState(undefined);
  const [existingEmailError, SetexistingEmailError] = useState(undefined);

  const onChangeFirstTime = (e) => {
    setfirstName(e.target.value);
  };

  const onChangeLastname = (e) => {
    setlastName(e.target.value);
  };

  const onChangeDateOfBirth = (e) => {
    setdateOfBirth(e.target.value);
  };

  const onChangeEmail = (e) => {
    setemail(e.target.value);
  };

  const onChangeSpecialization = (e) => {
    setspecialization(e.target.value);
  };

  const addStudentHandler = (e) => {
    e.preventDefault();

    let newStudent = {
      firstName: firstName,
      lastName: lastName,
      dateOfBirth: dateOfBirth,
      email: email,
      specialization: specialization,
      username:
        Math.random().toString(36).substring(2, 15) +
        Math.random().toString(36).substring(2, 15),
      password:
        Math.random().toString(36).substring(2, 15) +
        Math.random().toString(36).substring(2, 15),
      code:
        Math.random().toString(36).substring(2, 15) +
        Math.random().toString(36).substring(2, 15),
      role: "Student",
    };
    console.log(newStudent);
    axios
      .post("http://localhost:8080/Student/add", newStudent, {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((repos) => {
        SetrespondStatus(true);
        SetexistingEmailError(false)
      })
      .catch((error) => {
        SetrespondStatus(false);
        if(error.request.status === 500) {
          SetexistingEmailError(true)
        }
      });
  };

  const submitHandler = (e) => {
    e.preventDefault();
  }
  return (
    <>
      <div class="session">
        <div class="left">
          <Logo />
        </div>
        <div className="right">
          <form onSubmit={submitHandler}>
            <h1>
              <span className="movingtext">Henaknowledge platform</span> 
            </h1>
            <p>Here you can sign up a student in henaknowledge platform.</p>
            <h2>Add a student</h2>
            <input
              type="text"
              placeholder="firstName"
              onChange={onChangeFirstTime}
              value={firstName}
            />
            <input
              type="text"
              placeholder="lastName"
              onChange={onChangeLastname}
              value={lastName}
            />
            <input
              type="date"
              placeholder="dateOfBirth"
              onChange={onChangeDateOfBirth}
              value={dateOfBirth}
            />
            <input
              type="email"
              placeholder="email"
              onChange={onChangeEmail}
              value={email}
            />
            <input
              type="text"
              placeholder="specialization"
              onChange={onChangeSpecialization}
              value={specialization}
            />
            {
              existingEmailError &&
              <p style={{color:"red"}}>email exists</p>
            }
            <button type="submit" className="lf--submit" onClick={addStudentHandler}>
              Add
            </button>

            <Popup
              trigger={<button className="lf--submit">Help</button>}
              modal
              nested
            >
              <h1>Fill in the student details</h1>
              <h3>
                The student will receive an email with a username and password
                they can use to login!
              </h3>
            </Popup>
          </form>
          {respondStatus && (
            <Results
              Results={respondStatus}
              successMsg="Student has been added."
              errorMsg="Something went wrong."
              init="Please fill in the form and click on add"
            />
          )}
          {
            existingEmailError && 
            <Results
            Results={false}
            errorMsg="Email exists"
            />
          }
        </div>
      </div>
    </>
  );
}

export default AdminSignUpStudent;
