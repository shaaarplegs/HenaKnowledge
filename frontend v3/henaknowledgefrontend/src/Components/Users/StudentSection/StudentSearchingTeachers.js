import axios from "axios";
import React, { useState, useEffect } from "react";
import TeacherSearchingCard from "./TeacherSearchingCard";
import "./filtering.css";

function StudentSearchingTeachers() {
  const [chosenSpecialization, setchosenSpecialization] = useState("");
  const [teachers, setTeachers] = useState([]);
  const [isLoading, SetisLoading] = useState(false);
  const [searchTerm, setsearchTerm] = useState("");
  const [useSearch, setuseSearch] = useState(false);
  useEffect(() => {
    SetisLoading(true);
    axios
      .get(`http://localhost:8080/Teacher`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        SetisLoading(false);
        setTeachers(() => {
          return res.data;
        });
        console.log(res.data);
      })
      .catch((error) => {
        SetisLoading(false);
        console.log(error.response);
      });
  }, []);

  const onChangeFieldHandler = (e) => {
    e.preventDefault();
    setchosenSpecialization(e.target.value);
    setuseSearch(false);
  };
  const onChangeSearchTermHandler = (e) => {
    setsearchTerm(e.target.value);
    setuseSearch(false);
  };
  const onChangeuseSearchHandler = (e) => {
    setuseSearch(true);
  };
  return (
    <div>
      {isLoading && <p>Obtaining data...</p>}
      {!isLoading && (
        <div>
          <h2>Specify a specialization</h2>
          <div className="filteringoptions">
            <button onClick={onChangeFieldHandler} value="databases management">
              databases management
            </button>
            <button onClick={onChangeFieldHandler} value="front end developer">
              front end developer
            </button>

            <input
              type="text"
              value={searchTerm}
              onChange={onChangeSearchTermHandler}
              className="search__input"
              placeholder="search by first name, sir name or even email"
            />
            <button onClick={onChangeuseSearchHandler}>Search</button>
          </div>
        </div>
      )}
      <div className="studentfixcard">
        {!isLoading &&
          teachers
            .filter((val) => {
              if (!useSearch) {
                if (chosenSpecialization === "") {
                  return val;
                } else if (val.specialization === chosenSpecialization) {
                  return val;
                }
              } else {
                if (searchTerm === "") {
                  return val;
                } else if (
                  val.firstName
                    .toLowerCase()
                    .includes(searchTerm.toLowerCase()) ||
                  val.lastName
                    .toLowerCase()
                    .includes(searchTerm.toLowerCase()) ||
                  val.email.toLowerCase().includes(searchTerm.toLowerCase())
                ) {
                  return val;
                }
              }
            })
            .map((teacher) => {
              return (
                <TeacherSearchingCard
                  key={teacher.personID}
                  teacherID={teacher.personID}
                  firstName={teacher.firstName}
                  lastName={teacher.lastName}
                  email={teacher.email}
                  specialization={teacher.specialization}
                  contact={true}
                />
              );
            })}
      </div>
    </div>
  );
}

export default StudentSearchingTeachers;
