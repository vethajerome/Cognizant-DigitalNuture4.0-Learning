import React from "react";

const ListofIndianPlayers = ({ IndianPlayers }) => {
  return (
    <ul>
      {IndianPlayers.map((player, index) => (
        <li key={index}>
          Mr. {player}
        </li>
      ))}
    </ul>
  );
};

export default ListofIndianPlayers;