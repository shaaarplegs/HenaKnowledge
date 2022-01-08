import React, { useState, useEffect } from "react";
import Results from "../../Utility/Results";
import axios from "axios";
import StudentSearchingCard from "../StudentSection/StudentSearchingCard";
import { useHistory } from 'react-router'
function AdminDeleteStudent() {
  //todo
  const [RespondStatus, setRespondStatus] = useState(undefined);
  const [students, setStudents] = useState([]);
  const [isLoading, SetisLoading] = useState(false);
  const history = useHistory()
  useEffect(() => {
    SetisLoading(true);
    axios
      .get(`http://localhost:8080/Student`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        SetisLoading(false);
        setStudents(() => {
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
      .delete(`http://localhost:8080/Student?personID=${personID}`, {
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
          students.map((student) => {
            return (
              <StudentSearchingCard
                key={student.personID}
                firstName={student.firstName}
                lastName={student.lastName}
                email={student.email}
                contact={false}
                specialization={student.specialization}
                deleteStatus={true}
                deleteFun={(e) => {
                  onSubmitHandler(e, student.personID);
                }}
              />
            );
          })}

      {RespondStatus && (
        <Results
          Results={RespondStatus}
          init=" click on fire to delete the student from henaknowledge"
          successMsg="Student has been removed from henaknowledge."
          errorMsg="An error occured"
        />
      )}
    </div>
  );
}

export default AdminDeleteStudent;
