import React from "react";
import "./style.css";

export const Index = () => {
  return (
    <div className="index">
      <div className="div">
        <img
          className="coflag"
          alt="Coflag"
          src="https://cdn.animaapp.com/projects/6533ea14e18d82fa4b3a14b9/releases/653426f904f8d17797b4df12/img/coflag.png"
        />
        <div className="welcome">
          Welcome
          <br />
          ברוך הבא
          <br />
          مرحباً
        </div>
        <div className="text-wrapper">PeacePulse</div>
      </div>
    </div>
  );
};
