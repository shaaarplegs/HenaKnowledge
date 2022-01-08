import React, { useState, useEffect } from "react";
import axios from "axios";
import ContactCardTeacher from "../../Utility/ContactCardTeacher";

const StudentContactHistory = (props) => {
  const [contacts, setcontacts] = useState([]);
  const [isLoading, SetisLoading] = useState(false);
  useEffect(() => {
    SetisLoading(true);
    axios
      .get(
        `http://localhost:8080/ContactInfo/GetAllContacts?studentID=${localStorage.getItem(
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
            contact.wasUseful === 0 &&
            contact.wasNotUseful === 0 && (
              <ContactCardTeacher
                studentQuestion={contact.studentQuestion}
                teacherResponse={contact.teacherResponse}
                pending={contact.pending}
                wasUseful={contact.wasUseful}
                wasNotUseful={contact.wasNotUseful}
                teacherID={contact.teacherID}
                contactID={contact.id}
              />
            )
          );
        })}
        {
          contacts.filter((val)=> {
            if( val.wasUseful === 0 &&
              val.wasNotUseful === 0 ) {
                return val;
              }
          }).length === 0 && <p>There is no pending contacts.</p>
        } 
    </div>
  );
};

export default StudentContactHistory;
