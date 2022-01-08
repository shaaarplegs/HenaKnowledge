import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams } from "react-router";
import "./widget.css";
import CreateComment from "./Comments/CreateComment";
import Comments from "./Comments/Comments";

import Popup from "reactjs-popup";
import "reactjs-popup/dist/index.css";

const Experience = (props) => {
  const param = useParams();
  const [widget, SetWidget] = useState({});
  const [title, SetTitle] = useState("");
  const [description, Setdescription] = useState("");
  const [likes, setlikes] = useState("");
  const [dislikes, setdislikes] = useState("");
  const [isLoading, SetisLoading] = useState(false);
  const [ExperienceOpinion, SetExperienceOpinion] = useState({});

  useEffect(() => {
    SetisLoading(true);
    axios
      .get(
        `http://localhost:8080/Experience/getExperience?ExperienceID=${param.ExperienceID}`,
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("jwt")}`,
          },
        }
      )
      .then((res) => {
        SetisLoading(false);
        SetTitle(res.data.title);
        Setdescription(res.data.description);
        setlikes(res.data.likes);
        setdislikes(res.data.dislikes);
        SetisLoading(res.data.SetisLoading);
        SetWidget({
          experienceID: res.data.experienceID,
          personID: localStorage.getItem("personID"),
        });
      })
      .catch((error) => {
        SetisLoading(false);
      });

    axios
      .get(
        `http://localhost:8080/Experience/getExperienceOpinon?ExperienceID=${
          param.ExperienceID
        }&PersonID=${localStorage.getItem("personID")}`,
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("jwt")}`,
          },
        }
      )
      .then((res) => {
        SetExperienceOpinion(res.data);
      })
      .catch((error) => {
        console.log(error);
        SetExperienceOpinion({});
      });
  }, [likes, dislikes]);

  const Likehandler = (e) => {
    console.log(widget);
    axios.post(
      `http://localhost:8080/Experience/like?ExperienceID=${param.ExperienceID}`,
      widget,
      {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      }
    );
    window.location.reload(true);
  };

  const DisLikehandler = (e) => {
    console.log(widget);
    axios.post(
      `http://localhost:8080/Experience/dislike?ExperienceID=${param.ExperienceID}`,
      widget,
      {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      }
    );
    window.location.reload(true);
  };

  let likestyle;
  let dislike;
  if (ExperienceOpinion.likes === 1) {
    likestyle = "widgethasshared";
  } else {
    likestyle = "widgethasnotshared";
  }
  if (ExperienceOpinion.dislikes === 1) {
    dislike = "widgethasshared";
  } else {
    dislike = "widgethasnotshared";
  }
  return (
    <div>
      {isLoading && <p>obtaining data...</p>}
      {!isLoading && (
        <>
          <div class="sample-header">
            <div class="sample-header-section">
              <h1>{title}</h1>
            </div>
          </div>
          <div className="widget">
            <div>
              <button onClick={Likehandler} className={likestyle}>
                👍
              </button>
            </div>
            Likes: {likes}
            <div>
              <button onClick={DisLikehandler} className={dislike}>
                👎
              </button>
            </div>
            dislikes: {dislikes}
          </div>

          <div class="sample-section-wrap">
            <div class="sample-section" style={{ whiteSpace: "pre-wrap" }}>
              <p > {description} </p>
            </div>
          </div>
          <br></br>
          <h2>Add a comment </h2>
          <CreateComment
            personID={localStorage.getItem("personID")}
            experienceID={param.ExperienceID}
          />
          <br></br>
          <div className="commentBorder">
            <h2>Comments section</h2>
            <Comments ExperienceID={param.ExperienceID} />
          </div>
        </>
      )}
    </div>
  );
};

export default Experience;
