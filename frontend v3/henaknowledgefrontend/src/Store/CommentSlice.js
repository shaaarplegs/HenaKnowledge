import { createSlice } from "@reduxjs/toolkit";


const initCommentInfo = {
    UpdateComments: 0,
};

const CommentSlice = createSlice({
  name: "CommentUpdateCounter",
  initialState: initCommentInfo,
  reducers: {
    IncreateUpdateCommentsCounter(state, action) {
        state.UpdateComments ++
    },
  },
});

export const CommentActions = CommentSlice.actions;
export default CommentSlice.reducer;
