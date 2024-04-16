import styled from "styled-components";
import ImgCaesFundo from "../../assets/images/ImgCaesFundo.svg";

export const ContainerPai = styled.div`
  * {
    font-size: 1vw;
    font-family: "Roboto", sans-serif;
  }

  width: 100%;
  height: 100%;

  display: flex;
  align-items: center;
  justify-content: center;

  background-image: url(${ImgCaesFundo});
  background-size: cover;
  background-repeat: no-repeat;
  background-position: bottom;
  min-height: 100vh;
  min-width: 100vw;

  .ImgLogo {
    position: absolute;

    left: 0.5rem;
    top: 0.5rem;

    height: 20vh;
  }

  @media (max-width: 1024px) {
    .ImgLogo {
      height: 18vh;
    }
  }

  @media (max-width: 768px) {
    .ImgLogo {
      height: 16vh;
    }
  }

  @media (max-width: 480px) {
    .ImgLogo {
      height: 14vh;
    }
  }
`;

export const FormularioLogin = styled.form`
  background-color: white;
  width: 40%;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;

  border: 0.5px solid;
  border-color: rgba(200, 200, 200, 0.5);
  border-radius: 25px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);

  font-size: 1vw;
  font-family: "Roboto", sans-serif;

  @media (max-width: 1024px) {
    width: 45%;
    height: 60%;
  }

  @media (max-width: 768px) {
    width: 50%;
    height: 58%;
  }

  @media (max-width: 480px) {
    width: 60%;
    height: 55%;
  }
`;

export const Inputs = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  gap: 1.3rem;
  width: 100%;

  h1 {
    margin-top: 2.5rem;
    margin-bottom: 1.2rem;
    font-size: 2.5vw;
    font-family: "roboto-medium", sans-serif;
  }

  input {
    width: 55%;
    height: 2.7rem;

    border-radius: 15px;
    border: 1.5px solid;
    border-color: rgba(200, 200, 200, 0.5);

    padding-left: 1.5rem;
    padding-right: 3rem;

    &:focus {
      background: rgb(231, 245, 250);
      border: 0.1px solid rgb(104, 178, 224);
      outline: none !important;
    }
  }

  .divOlhoAbertoOuFechado {
    width: 100%;

    display: flex;
    justify-content: center;

    &:last-child {
      position: relative;

      .OlhoAbertoOuFechado {
        position: absolute;
        top: 50%;
        left: 70%;
        transform: translate(-50%, -50%);
      }
    }
  }

  @media (max-width: 1024px) {
    h1 {
      font-size: 3.5vw;
    }

    input {
      width: 60%;
      height: 3.2rem;

      font-size: 2vw;
    }
  }

  @media (max-width: 768px) {
    h1 {
      font-size: 4vw;

      margin-top: 2rem;
      margin-bottom: 2.5rem;
    }

    input {
      font-size: 2.4vw;
    }
  }

  @media (max-width: 480px) {
    h1 {
      font-size: 5vw;

      margin-top: 1rem;
      margin-bottom: 3rem;
    }

    input {
      font-size: 3vw;
    }
  }
`;

export const NaoTemConta = styled.div`
  display: flex;
  position: relative;
  flex-direction: column;
  align-items: center;

  width: 100%;

  .divButton {
    display: flex;
    position: relative;
    flex-direction: row;
    justify-content: center;

    width: 100%;

    button {
      background-color: #1976d2;
      color: white;

      border: none;
      border-radius: 15px;

      width: 30%;
      height: 2.7rem;

      margin-top: 2rem;
    }
  }

  div {
    width: 59%;
    padding-bottom: 1.6rem;
    display: flex;
    flex-direction: column;
    gap: 1rem;
  }

  .LogarCom {
    position: relative;
    top: 0.3rem;

    padding-left: 1.5rem;
    padding-right: 1.5rem;
  }
  @media (max-width: 1024px) {
    .divButton {
      button {
        margin-top: 3rem;

        width: 30%;

        font-size: 2.3vw;
      }
    }

    div {
      margin-bottom: 0.5rem;
    }

    .LogarCom {
      font-size: 2.3vw;
    }
  }

  @media (max-width: 768px) {
    .divButton {
      button {
        font-size: 2.5vw;
      }
    }

    .LogarCom {
      font-size: 2.5vw;
    }
  }

  @media (max-width: 480px) {
    .divButton {
      button {
        width: 35%;

        font-size: 3.5vw;

        margin-top: 3rem;
        margin-bottom: 0.5rem;
      }
    }

    .LogarCom {
      font-size: 3.5vw;
    }
  }
`;

export const ImgsLogos = styled.div`
  width: 100%;

  display: flex;
  flex-direction: row;
  position: relative;

  justify-content: space-evenly;

  padding: 1rem;

  div {
    margin-top: 0.5rem;
    margin-bottom: 0.5rem;

    width: 20%;
    height: 2.5rem;

    border-radius: 20px;

    &.divFacebook {
      background-color: #1976d2;

      display: flex;
      align-items: center;
      justify-content: center;

      .ImgFacebook {
        cursor: pointer;

        color: white;

        width: 2rem;
        height: 1.7rem;
      }
    }

    &.divGoogle {
      background-color: white;

      display: flex;
      align-items: center;
      justify-content: center;

      border: 2px solid;
      border-color: rgba(200, 200, 200, 0.5);
      .ImgGoogle {
        cursor: pointer;

        color: red;

        width: 2rem;
        height: 1.7rem;
      }
    }

    &.divApple {
      background-color: black;

      display: flex;
      align-items: center;
      justify-content: center;

      .ImgApple {
        cursor: pointer;

        color: white;

        width: 2rem;
        height: 1.7rem;
      }
    }
  }

  @media (max-width: 1024px) {
    margin-top: 0.7rem;

    div {
      width: 27%;
    }
  }

  @media (max-width: 768px) {
    margin-top: 1rem;

    div {
      width: 27%;
    }
  }

  @media (max-width: 480px) {
    margin-top: 1.5rem;

    div {
      width: 27%;
    }
  }
`;
