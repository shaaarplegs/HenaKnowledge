import axios from "axios";
import React, { useState, useEffect } from "react";
import Points from "../../Utility/Points";
import Popup from "reactjs-popup";
import "reactjs-popup/dist/index.css";

const StudentPoints = (props) => {
  const [user, setuser] = useState({});
  const [isLoading, SetisLoading] = useState(false);
  useEffect(() => {
    SetisLoading(true);
    axios
      .get(
        `http://localhost:8080/Student/getStudent?username=${localStorage.getItem(
          "username"
        )}`,
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("jwt")}`,
          },
        }
      )
      .then((res) => {
        SetisLoading(false);
        setuser(res.data);
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
      {!isLoading && <Points Points={user.points} Code={user.code} />}
      <Popup trigger={<button>Help</button>} modal nested>
        <h1>
          Be active, share your experiences and ask more to gain more points.
        </h1>
        <h3>
          Eventually you can exchange them for money after contacting an admin!
        </h3>
      </Popup>
      <br></br>
      <br></br>
      <br></br>
      Send an email to <strong>henaknowledgenoreply@gmail.com</strong> 
      asking for redeem request and do not forget to provide your own code.
    </div>
  );
};

export default StudentPoints;
