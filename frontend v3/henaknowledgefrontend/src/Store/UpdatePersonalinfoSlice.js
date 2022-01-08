import { createSlice } from "@reduxjs/toolkit";


const initPersonalInfo = {
  firstname: "",
  lastname: "",
  email: "",
};

const UPIslice = createSlice({
  name: "UpdatePersonalInfo",
  initialState: initPersonalInfo,
  reducers: {
    updateInfo(state, action) {
        state.firstName = action.payload.firstName
        state.lastName = action.payload.lastName
        state.email = action.payload.email

        localStorage.setItem('firstName',  action.payload.firstName)
        localStorage.setItem('lastName',  action.payload.lastName)
        localStorage.setItem('email',  action.payload.lastName)

        console.log(action.payload)
    },
  },
});

export const UPIactions = UPIslice.actions;
export default UPIslice.reducer;
