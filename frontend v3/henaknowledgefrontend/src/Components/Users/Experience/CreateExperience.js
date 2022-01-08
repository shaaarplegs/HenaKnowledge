import React, { useState } from "react";
import "./style.css";
import axios from "axios";
import Logo from "../../../Logo/Logo";
import Popup from "reactjs-popup";
import Results from "../../../Components/Utility/Results";

const CreateExperience = (props) => {
  
  const [title, SetTitle] = useState("");
  const [description, SetDescription] = useState("");
  const [respondStatus, SetrespondStatus] = useState(undefined);

  const ChangeTitleHandler = (e) => {
    SetTitle(e.target.value);
  };
  const ChangeDescriptionHandler = (e) => {
    SetDescription(e.target.value);
  };


  const PostExperienceHandler = (e) => {
    e.preventDefault();
    let newExperience = {
      description: description,
      dislikes: 0,
      likes: 0,
      personID: localStorage.getItem("personID"),
      title: title,
    };

    axios
      .post("http://localhost:8080/Experience/Add", newExperience, {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((repos) => {
        SetrespondStatus(true);
      })
      .catch((error) => {
        console.log("error has occured");
        SetrespondStatus(false);
      });

      SetTitle('')
      SetDescription('')
      SetrespondStatus(undefined)
  };

  return (
    <>
      <div class="session">
        <div class="left">
          <Logo />
        </div>
        <div className="right">
          <form onSubmit={PostExperienceHandler}>
            <h1>
              <span className="movingtext">Henaknowledge platform</span>
            </h1>
            <p>Share your experience with other henaknowledge users!</p>
            <h2>Post an experience</h2>

            <input
              type="text"
              placeholder="enter title"
              onChange={ChangeTitleHandler}
              value={title}
              required
            />
            <textarea
              type=""
              placeholder="enter description"
              onChange={ChangeDescriptionHandler}
              value={description}
              required
            />
            <button
              type="submit"
              className="lf--submit"
            >
              Share
            </button>

            <Popup
              trigger={<button className="lf--submit">Help</button>}
              modal
              nested
            >
              <h1>Fill in the experience details</h1>
              <h3>
                All henaknowledge users will be able to see your experience,
                comment it and like or dislike it.
              </h3>
            </Popup>
          </form>
          {respondStatus && (
            <Results
              Results={respondStatus}
              successMsg="Experience has been shared."
              errorMsg="Something went wrong."
              init="Please fill in the form and click on add"
            />
          )}
        </div>
      </div>
    </>
  );
};

export default CreateExperience;
