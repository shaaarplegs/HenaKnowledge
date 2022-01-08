import { createSlice, configureStore } from "@reduxjs/toolkit";

import AuthSlice from "./AuthSlice";

import UPIslice from "./AuthSlice";

import CommentSlice from "./CommentSlice";

const MainStore = configureStore({
  reducer: { auth: AuthSlice, UPI: UPIslice, CommentStore: CommentSlice },
});

export default MainStore;
