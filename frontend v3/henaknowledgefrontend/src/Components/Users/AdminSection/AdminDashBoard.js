import axios from "axios";
import React, { useState, useEffect } from "react";
import Results from "../../Utility/Results";
import Logo from "../../../Logo/Logo";


const AdminDashBoard = (props) => {
  const [pointsPerExperience, SetpointsPerExperience] = useState(0);
  const [pointsPerLike, SetpointsPerLike] = useState(0);
  const [pointsPerDislike, SetpointsPerDislike] = useState(0);
  const [pointsPerQuestion, SetpointsPerQuestion] = useState(0);
  const [pointsPerAnswer, SetpointsPerAnswer] = useState(0);
  const [updateStatus, SetupdateStatus] = useState(undefined);
  //1
  useEffect(() => {
    axios
      .get(`http://localhost:8080/Admin/GetPointsPerExperience`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        SetpointsPerExperience(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error.response);
      });
  }, []);

  //2
  useEffect(() => {
    axios
      .get(`http://localhost:8080/Admin/GetPointsPerLike`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        SetpointsPerLike(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error.response);
      });
  }, []);

  //3
  useEffect(() => {
    axios
      .get(`http://localhost:8080/Admin/GetPointsPerDislike`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        SetpointsPerDislike(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error.response);
      });
  }, []);

  //4
  useEffect(() => {
    axios
      .get(`http://localhost:8080/Admin/GetPointsPerQuestion`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        SetpointsPerQuestion(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error.response);
      });
  }, []);

  //5
  useEffect(() => {
    axios
      .get(`http://localhost:8080/Admin/GetPointsPerAnswer`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        SetpointsPerAnswer(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error.response);
      });
  }, []);

  const ChangepointsPerExperienceHandler = (e) => {
    SetpointsPerExperience(e.target.value);
  };
  const ChangepointsPerLikeHandler = (e) => {
    SetpointsPerLike(e.target.value);
  };
  const ChangepointsPerDislikeHandler = (e) => {
    SetpointsPerDislike(e.target.value);
  };
  const ChangepointsPerQuestionHandler = (e) => {
    SetpointsPerQuestion(e.target.value);
  };
  const ChangepointsPerAnswerHandler = (e) => {
    SetpointsPerAnswer(e.target.value);
  };

  const onSubmitFormHandler = (e) => {
    e.preventDefault();
    axios
    .get(`http://localhost:8080/Admin/ChangePointsPerExperience?pointsPerExperience=${pointsPerExperience}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
    })
    axios
    .get(`http://localhost:8080/Admin/ChangePointsPerLike?pointsPerLike=${pointsPerLike}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
    })
    axios
    .get(`http://localhost:8080/Admin/ChangePointsPerDislike?pointsPerDislike=${pointsPerDislike}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
    })
    axios
    .get(`http://localhost:8080/Admin/ChangePointsPerQuestion?pointsPerQuestion=${pointsPerQuestion}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
    })
    axios
    .get(`http://localhost:8080/Admin/ChangePointsPerAnswer?pointsPerAnswer=${pointsPerAnswer}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
    })
    SetupdateStatus(true);
  };
  return (
    <>
      <div class="session">
        <div class="left">
          <Logo />
        </div>

        <div>
          <form onSubmit={onSubmitFormHandler} classNameName="log-in">
            <h1>Dash board</h1>
            <p>
              Change points students and teachers can earn when they are active!
            </p>
            Points Per Experience:
            <div class="floating-label">
              <input
                type="text"
                value={pointsPerExperience}
                onChange={ChangepointsPerExperienceHandler}
              />
            </div>
            Points Per Like:
            <div class="floating-label">
              <input
                type="text"
                value={pointsPerLike}
                onChange={ChangepointsPerLikeHandler}
              />
            </div>
            Points Per Dislike:
            <div class="floating-label">
              <input
                type="text"
                value={pointsPerDislike}
                onChange={ChangepointsPerDislikeHandler}
              />
            </div>

            Points Per Question:
            <div class="floating-label">
              <input
                type="text"
                value={pointsPerQuestion}
                onChange={ChangepointsPerQuestionHandler}
              />
            </div>
            Points Per Answer:
            <div class="floating-label">
              <input
                type="text"
                value={pointsPerAnswer}
                onChange={ChangepointsPerAnswerHandler}
              />
            </div>
            <button className="LoginBtn" type="submit">
              update
            </button>
            {updateStatus && (
              <Results
                Results={updateStatus}
                successMsg="Points earned updated"
              />
            )}
          </form>
        </div>
      </div>
    </>
  );
};

export default AdminDashBoard;
