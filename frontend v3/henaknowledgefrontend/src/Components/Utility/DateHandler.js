import React, { useState } from "react";
import {dateFormat } from 'dateformat';

const DateHandler = (props) => {

  var d = new Date(props.obtainedTimestamp).toLocaleDateString("en-US")
  return (
      <>
      {
          d
      }
      </>
  )
};

export default DateHandler;


