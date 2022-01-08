import React, { useState, useEffect } from "react";
import axios from "axios";
import ContactCardStudent from '../../Utility/ContactCardStudent'

const TeacherHistoryQuestions = (props) => {
  const [contacts, setcontacts] = useState([]);
  const [isLoading, SetisLoading] = useState(false);

  useEffect(() => {
    SetisLoading(true);
    axios
      .get(
        `http://localhost:8080/ContactInfo/GetAllContactsByTeacherID?teacherID=${localStorage.getItem(
          "personID"
        )}`,
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("jwt")}`,
          },
        }
      )
      .then((res) => {
        SetisLoading(false);
        setcontacts(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        SetisLoading(false);
        console.log(error.response);
      });
  }, []);

  return (
    <div>
      {isLoading && <p>Obtaining data...</p>}
      {!isLoading &&
        contacts.map((contact) => {
          return (
            <ContactCardStudent 
            studentID={contact.studentID}
            contactID={contact.id}
            />
          );
        })}
    </div>
  );
};

export default TeacherHistoryQuestions;
