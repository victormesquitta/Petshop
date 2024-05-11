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

  box-sizing: border-box;

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
  @media (max-width: 480px) {
    .ImgLogo {
      height: 10vh;
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

  box-sizing: border-box;

  border: 0.5px solid;
  border-color: rgba(200, 200, 200, 0.5);
  border-radius: 25px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);

  font-size: 1vw;
  font-family: "Roboto", sans-serif;

  @media (max-width: 1024px) {
    height: 90%;
    width: 50%;

    margin-top: 5rem;
  }
  @media (max-width: 768px) {
    width: 60%;
    height: 70%;

    margin-top: 8rem;
  }

  @media (max-width: 480px) {
    width: 80%;
    height: 68%;

    margin-top: 5rem;

    padding-top: 1rem;
    padding-bottom: 1rem;
  }
`;

export const Inputs = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;

  h1 {
    margin-top: 2.5rem;
    margin-bottom: 3.5rem;
    font-size: 2.5vw;
    font-family: "roboto-medium", sans-serif;
  }

  @media (max-width: 1024px) {
    h1 {
      font-size: 4vw;
    }
  }

  @media (max-width: 768px) {
    h1 {
      font-size: 5vw;
    }
  }

  @media (max-width: 480px) {
    h1 {
      font-size: 6.5vw;
    }
  }
`;

export const NaoTemConta = styled.div`
  display: flex;
  position: relative;
  flex-direction: column;
  align-items: center;

  width: 100%;

  div {
    width: 59%;
    padding-bottom: 1.6rem;
    display: flex;
    flex-direction: column;
    gap: 1rem;

    .NaoTemConta{
      margin-left: 1rem;

      .Links{
        margin-left: .5rem;

        text-decoration: none;

        &:hover{
          text-decoration: underline;
        }
      }
    }
  }

  .LogarCom {
    position: relative;
    top: 0.3rem;

    padding-left: 1.5rem;
    padding-right: 1.5rem;
  }

  @media (max-width: 1024px) {
    .Links {
      font-size: 2vw;

      margin-top: 0.5rem;
    }

    .LogarCom {
      font-size: 2.5vw;
    }
  }

  @media (max-width: 768px) {
    .Links {
      font-size: 3vw;

      margin-top: 1rem;
    }

    .LogarCom {
      font-size: 3vw;
    }
  }

  @media (max-width: 480px) {
    div {
      gap: 1.5rem;
    }

    .Links {
      font-size: 4vw;
    }

    .LogarCom {
      font-size: 5.5vw;
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

    width: 12%;
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
    div {
      height: 3.3rem;
      width: 28%;

      margin-top: 1.5rem;
    }
  }

  @media (max-width: 768px) {
    div {
      height: 3.3rem;
      width: 28%;

      margin-top: 1rem;
    }
  }

  @media (max-width: 480px) {
    div {
      height: 2.8rem;
      width: 28.5%;
    }
  }
`;
