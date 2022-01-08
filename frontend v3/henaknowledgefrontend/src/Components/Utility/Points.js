import React from 'react'

const Points = props => {
    return (
        <div>
            <h1>Points Page</h1>
            <h3>Points : {props.Points}</h3>
            <h3>Code : {props.Code}</h3>
        </div>
    )
}

export default Points
