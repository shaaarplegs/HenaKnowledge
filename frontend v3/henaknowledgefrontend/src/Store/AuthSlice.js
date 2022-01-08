import { createSlice } from "@reduxjs/toolkit";
import jwt_decode from "jwt-decode";

let loginState = false;

if (
  localStorage.getItem("jwt") !== null &&
  localStorage.getItem("jwt") !== null
) {
  loginState = true;
}
let ObtainedUserType;
if (localStorage.getItem("userType") !== null) {
  ObtainedUserType = localStorage.getItem("userType");
}
const initAuth = {
  isLoggedin: loginState,
  userType: ObtainedUserType,
  expirationDate: 0,
};

const AuthSlice = createSlice({
  name: "Authentication",
  initialState: initAuth,
  reducers: {
    logout(state) {
      state.isLoggedin = false;
      state.userType = "";
      state.expirationDate = "";
      localStorage.clear();
    },

    login(state, action) {

      //get the token
      localStorage.setItem("jwt", action.payload.jwt);

      //decode the generated token to extract data
      var token = localStorage.getItem("jwt");
      var decoded = jwt_decode(token);

      /* example
        decoded {
          exp: 1622236209
         iat: 1621372209
         role: "Student"
          sub: "bb"
        }
      */

        //set local information from the generated token.
      localStorage.setItem("username", decoded.sub);
      localStorage.setItem("userType", decoded.role);
      localStorage.setItem("expirationDate", decoded.exp);

      state.isLoggedin = true;
      state.userType = localStorage.getItem('userType');
      state.expirationDate = localStorage.getItem('expirationDate');
    },
  },
});

export const AuthActions = AuthSlice.actions;
export default AuthSlice.reducer;
