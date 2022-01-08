import axios from "axios";
import React, { useEffect, useState } from "react";
import HKComment from "./Comment";
import { useSelector } from "react-redux";

const Comments = (props) => {
  const [comments, SetComments] = useState([]);
  const [isLoading, SetisLoading] = useState("");
  const UpdateComments = useSelector(
    (state) => state.CommentStore.UpdateComments
  );
  useEffect(() => {
    SetisLoading(true);
    axios
    .get(`http://localhost:8080/Comment/getAllCommentsOfExperienceID?ExperienceID=${props.ExperienceID}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
    }).then((res)=>{
        SetisLoading(false);
        SetComments(res.data);
    })
  }, [UpdateComments]);

  return (
    <div>
      {isLoading && <p>loading comments....</p>}
      {!isLoading && comments.length !== 0 && 
        comments.map((comment) => {
          return (
            <HKComment
              key={comment.commentID}
              commentBody={comment.commentBody}
              personID={comment.personID}
            />
          );
        })}
    </div>
  );
};

export default Comments;
