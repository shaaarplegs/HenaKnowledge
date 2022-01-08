  import React, { useState, useEffect } from "react";
import Results from "../../Utility/Results";
import axios from "axios";
import TeacherSearchingCard from "../StudentSection/TeacherSearchingCard";
import { useHistory } from 'react-router'
import AdminSearchingTeacherCard from "./AdminSearchingTeacherCard";
function AdminDeleteTeacher() {
  //todo
  const [RespondStatus, setRespondStatus] = useState(undefined);
  const [teachers, setTeachers] = useState([]);
  const [isLoading, SetisLoading] = useState(false);
  const history = useHistory()
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

  const onSubmitHandler = (e, personID) => {
    
    axios
      .delete(`http://localhost:8080/Teacher?personID=${personID}`, {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((respon) => {
        setRespondStatus(true);
      })
      .catch((error) => {
        setRespondStatus(false);
      });
    console.log(RespondStatus);
    history.go(0)
  };

  return (
    <div className="admin">
        {isLoading && <p>Loading...</p>}

        {!isLoading &&
          teachers.map((teacher) => {
            return (
              <AdminSearchingTeacherCard
                key={teacher.personID}
                firstName={teacher.firstName}
                lastName={teacher.lastName}
                email={teacher.email}
                specialization={teacher.specialization}
                deleteStatus={true}
                deleteFun={(e)=>{onSubmitHandler(e, teacher.personID)}}
              />
            );
          })}

      {RespondStatus && (
        <Results
          Results={RespondStatus}
          init=" click on fire to delete the teacher from henaknowledge"
          successMsg="Teacher has been removed from henaknowledge."
          errorMsg="An error occured"
        />
      )}
    </div>
  );
}

export default AdminDeleteTeacher;
