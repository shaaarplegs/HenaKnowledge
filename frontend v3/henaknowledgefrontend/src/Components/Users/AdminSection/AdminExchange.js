import axios from "axios";
import React, { useState, useEffect } from "react";
import Logo from "../../../Logo/Logo";
import Results from "../../Utility/Results";
const AdminExchange = (props) => {
  const [user, SetUser] = useState({});
  const [Code, SetCode] = useState("");
  const [studentID, SetstudentID] = useState(0);
  const [teacherID, SetteacherID] = useState(0);
  const [userDoesNotExistError, SetuserDoesNotExistError] = useState(false);
  const [RedeemStatus, SetRedeemStatus] = useState(undefined);

  const ChangeCodeHandler = (e) => {
    SetCode(e.target.value);
  };

  const GetPersonDetailsHandler = (e) => {
    e.preventDefault();
    axios
      .get(`http://localhost:8080/Person/getPersonID?Code=${Code}`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        if (res.data === 0) {
          console.log("user does not exist");
          SetuserDoesNotExistError(true);
        } else if (res.data !== 0) {
          axios
            .get(`http://localhost:8080/Student/${res.data}`, {
              headers: {
                Authorization: `Bearer ${localStorage.getItem("jwt")}`,
              },
            })
            .then((studentRes) => {
              SetuserDoesNotExistError(false);
              SetUser(studentRes.data);
              if (studentRes.data !== null) {
                SetstudentID(studentRes.data.personID);
              }
            })
            .catch((error) => {
              console.log("this code belongs to a teacher");
              axios
                .get(`http://localhost:8080/Teacher/${res.data}`, {
                  headers: {
                    Authorization: `Bearer ${localStorage.getItem("jwt")}`,
                  },
                })
                .then((TeacherRes) => {
                  SetuserDoesNotExistError(false);
                  console.log(TeacherRes.data);
                  SetUser(TeacherRes.data);
                  SetteacherID(TeacherRes.data.personID);
                });
            });
        }
      });
  };

  const RedeemStudentPoints = (e) => {
    e.preventDefault();
    axios.get(
      `http://localhost:8080/Admin/ReedemStudentPoints?studentID=${studentID}`,
      {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      }
    );

    axios
      .get(`http://localhost:8080/Person/getPersonID?Code=${Code}`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        if (res.data === 0) {
          console.log("user does not exist");
          SetuserDoesNotExistError(true);
        } else if (res.data !== 0) {
          axios
            .get(`http://localhost:8080/Student/${res.data}`, {
              headers: {
                Authorization: `Bearer ${localStorage.getItem("jwt")}`,
              },
            })
            .then((studentRes) => {
              SetuserDoesNotExistError(false);
              SetUser(studentRes.data);
              if (studentRes.data !== null) {
                SetstudentID(studentRes.data.personID);
              }
            })
            .catch((error) => {
              console.log("this code belongs to a teacher");
              axios
                .get(`http://localhost:8080/Teacher/${res.data}`, {
                  headers: {
                    Authorization: `Bearer ${localStorage.getItem("jwt")}`,
                  },
                })
                .then((TeacherRes) => {
                  SetuserDoesNotExistError(false);
                  console.log(TeacherRes.data);
                  SetUser(TeacherRes.data);
                  SetteacherID(TeacherRes.data.personID);
                });
            });
        }
      });
      SetRedeemStatus(true);
  };

  const RedeemTeacherPoints = (e) => {
    e.preventDefault();
    axios.get(
      `http://localhost:8080/Admin/ReedemTeacherPoints?teacherID=${teacherID}`,
      {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      }
    );

    axios
      .get(`http://localhost:8080/Person/getPersonID?Code=${Code}`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        if (res.data === 0) {
          console.log("user does not exist");
          SetuserDoesNotExistError(true);
        } else if (res.data !== 0) {
          axios
            .get(`http://localhost:8080/Student/${res.data}`, {
              headers: {
                Authorization: `Bearer ${localStorage.getItem("jwt")}`,
              },
            })
            .then((studentRes) => {
              SetuserDoesNotExistError(false);
              SetUser(studentRes.data);
              if (studentRes.data !== null) {
                SetstudentID(studentRes.data.personID);
              }
            })
            .catch((error) => {
              console.log("this code belongs to a teacher");
              axios
                .get(`http://localhost:8080/Teacher/${res.data}`, {
                  headers: {
                    Authorization: `Bearer ${localStorage.getItem("jwt")}`,
                  },
                })
                .then((TeacherRes) => {
                  SetuserDoesNotExistError(false);
                  console.log(TeacherRes.data);
                  SetUser(TeacherRes.data);
                  SetteacherID(TeacherRes.data.personID);
                });
            });
        }
      });
    SetRedeemStatus(true);
  };

  return (
    <>
      <div class="session">
        <div class="left">
          <Logo />
        </div>

        <div>
          <form classNameName="log-in">
            <h1>Dash board</h1>
            <p>
              Change points students and teachers can earn when they are active!
            </p>
            Enter the code:
            <div class="floating-label">
              <input type="text" value={Code} onChange={ChangeCodeHandler} />
            </div>
            <button
              className="LoginBtn"
              type="submit"
              onClick={GetPersonDetailsHandler}
            >
              Get Person details
            </button>
            <br></br>
            {userDoesNotExistError && (
              <div>
                <h2>There is no person with the specified code.</h2>
                <br></br> <p style={{ color: "Red" }}>please try again!</p>
              </div>
            )}
            {!userDoesNotExistError && user.role === "Student" && (
              <div>
                <h2 style={{ textAlign: "left" }}>Student details</h2>
                <br></br>
                <h3 style={{ textAlign: "left" }}>
                  Full name:{" "}
                  <p
                    style={{
                      display: "block",
                      fontSize: "25px",
                      textAlign: "left",
                    }}
                  >
                    {user.firstName} {user.lastName}
                  </p>
                </h3>
                <h3 style={{ textAlign: "left" }}>
                  Email:{" "}
                  <p
                    style={{
                      display: "block",
                      fontSize: "25px",
                      textAlign: "left",
                    }}
                  >
                    {user.email}
                  </p>
                </h3>
                <h3 style={{ textAlign: "left" }}>
                  Points:{" "}
                  <p
                    style={{
                      display: "block",
                      fontSize: "25px",
                      textAlign: "left",
                    }}
                  >
                    {user.points}
                  </p>
                </h3>
                <button onClick={RedeemStudentPoints}>Redeem Points</button>
              </div>
            )}
            {!userDoesNotExistError && user.role === "Teacher" && (
              <div>
                <h2 style={{ textAlign: "left" }}>Teacher details</h2>
                <br></br>
                <h3 style={{ textAlign: "left" }}>
                  Full name:{" "}
                  <p
                    style={{
                      display: "block",
                      fontSize: "25px",
                      textAlign: "left",
                    }}
                  >
                    {user.firstName} {user.lastName}
                  </p>
                </h3>
                <h3 style={{ textAlign: "left" }}>
                  Email:{" "}
                  <p
                    style={{
                      display: "block",
                      fontSize: "25px",
                      textAlign: "left",
                    }}
                  >
                    {user.email}
                  </p>
                </h3>
                <h3 style={{ textAlign: "left" }}>
                  Points:{" "}
                  <p
                    style={{
                      display: "block",
                      fontSize: "25px",
                      textAlign: "left",
                    }}
                  >
                    {user.points}
                  </p>
                </h3>
                <button onClick={RedeemTeacherPoints}>Redeem Points</button>
              </div>
            )}
          </form>
        </div>
        {RedeemStatus && (
            <Results
              Results={RedeemStatus}
              successMsg="Points has been rest"
            />
          )}
      </div>
    </>
  );
};

export default AdminExchange;
