import axios from "axios";
import React, { useState, useEffect, Fragment } from "react";
import Results from "../../Utility/Results";
import Logo from "../../../Logo/Logo";

const UpdateTeacherProfile = (props) => {
  const [user, setuser] = useState({});
  const [isLoading, SetisLoading] = useState(false);
  useEffect(() => {
    SetisLoading(true);
    axios
      .get(
        `http://localhost:8080/Teacher/getTeacher?username=${localStorage.getItem(
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

  const [firstName, setfirstName] = useState(localStorage.getItem("firstName"));
  const [lastName, setlastName] = useState(localStorage.getItem("lastName"));
  const [email, setemail] = useState(localStorage.getItem("email"));

  const onChangeFirstnameHandler = (e) => {
    setfirstName(e.target.value);
  };

  const onChangeLastnameHandler = (e) => {
    setlastName(e.target.value);
  };

  const onChangeEmailHandler = (e) => {
    setemail(e.target.value);
  };

  const [updateStatus, SetUpdateStatus] = useState(undefined);

  const onSubmitHandler = (e) => {

    fetch(
      `http://localhost:8080/Teacher?PersonID=${user.personID}&first_name=${firstName}&last_name=${lastName}&email=${email}`,
      {
        method: "PUT",

        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
          "Access-Control-Allow-Origin": "*",
          "Content-Length": "0",
        },
      }
    )
      .then((respo) => {
        SetUpdateStatus(true);
        setuser(respo.data)
        console.log("data:");
        console.log(respo.data);
      })
      .catch((error) => {
        SetUpdateStatus(false);
        console.log(error);
      });

      localStorage.setItem('firstName', firstName)
      localStorage.setItem('lastName', lastName)
      localStorage.setItem('email', email)
  };

  return (
    <div class="session">
      <div class="left">
        <Logo />
      </div>
      <div className="right">
        <form onSubmit={onSubmitHandler}>
          <h1 className="movingtext">
            <span>Henaknowledge  platform</span>
          </h1>
          <p>You can update your personal information in this section.</p>
          {isLoading && <p>Retreiving information... </p>}
          {!isLoading && (
            <Fragment>
              <label>Update your profile</label>
              <input
                type="text"
                required
                onChange={onChangeFirstnameHandler}
                value={firstName}
                // defaultValue={localStorage.getItem('firstName')}
              />
              <input
                type="text"
                required
                onChange={onChangeLastnameHandler}
                value={lastName}
                defaultValue={localStorage.getItem('lastName')}
              />
              <input
                type="email"
                required
                onChange={onChangeEmailHandler}
                value={email}
                defaultValue={localStorage.getItem('email')}
              />

              <button type="submit">Update information</button>
            </Fragment>
          )}
          {updateStatus && (
            <Results
              Results={updateStatus}
              successMsg="Information updated successfully"
              errorMsg="Something went wrong."
              init="Please fill in the form and click on update"
            />
          )}
        </form>
      </div>
    </div>
  );
};

export default UpdateTeacherProfile;
