import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import axios from "axios";
import "./StudentContact.css";
const StudentContact = (props) => {
  const param = useParams();
  const [isLoading, SetisLoading] = useState(false);
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

  const wasUsefulhandler = (e) => {
    let updatedContact;
    updatedContact = {
      id: contactInfo.id,
      studentQuestion: contactInfo.studentQuestion,
      teacherResponse: contactInfo.teacherResponse,
      pending: 0,
      wasUseful: 1,
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
    window.location.replace('/')
  };

  const wasNotUsefulhandler = (e) => {
    let updatedContact;
    updatedContact = {
      id: contactInfo.id,
      studentQuestion: contactInfo.studentQuestion,
      teacherResponse: contactInfo.teacherResponse,
      pending: 0,
      wasUseful: 0,
      wasNotUseful: 1,
      studentID: contactInfo.studentID,
      teacherID: contactInfo.teacherID,
    };

    axios.put("http://localhost:8080/ContactInfo", updatedContact, {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
    });
    window.location.replace('/')
  };
  return (
    <div>
      {isLoading && <p>obtaining data...</p>}
      {!isLoading && (
        <div>
          Your question :
          <div className="question">
            <p>{contactInfo.studentQuestion}</p>
          </div>
          Teacher response
          <div className="response">
            {contactInfo.pending === 1 && (
              <p>Teacher has not yet responded to your question...</p>
            )}
            {contactInfo.pending === 0 && (
              <>
                <p>{contactInfo.teacherResponse}</p>

                <button onClick={wasUsefulhandler}>Was useful</button>

                <button onClick={wasNotUsefulhandler}>Was not useful</button>
              </>
            )}
          </div>
        </div>
      )}
    </div>
  );
};

export default StudentContact;
