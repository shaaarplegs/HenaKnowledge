import React, { useState, useEffect } from "react";
import axios from "axios";
import "./commentstyle.css";

import { useDispatch } from "react-redux";
import { CommentActions } from "../../../../Store/CommentSlice";
const CreateComment = (props) => {
  const dispatch = useDispatch();

  const [comment, SetComment] = useState("");

  const OnChangeCommentHandler = (e) => {
    SetComment(e.target.value);
  };

  const onSubmitHandler = (e) => {
    let newComment = {
      personID: props.personID,
      commentBody: comment,
      experienceID: props.experienceID,
    };

    axios.post("http://localhost:8080/Comment/Add", newComment, {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
    }).then(
      (res)=>{
        dispatch(CommentActions.IncreateUpdateCommentsCounter())
      }
    );
  
  };
  return (
    <div className="addingComment">
      <div className="commentarea">
        <textarea
          placeholder="Type your comment..."
          value={comment}
          onChange={OnChangeCommentHandler}
        />
      </div>

      <button onClick={onSubmitHandler}>Add comment</button>
    </div>
  );
};

export default CreateComment;
