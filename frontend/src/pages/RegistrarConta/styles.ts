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
  height: 60%;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;

  border: 0.5px solid;
  border-color: rgba(200, 200, 200, 0.5);
  border-radius: 25px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);

  font-size: 1vw;
  font-family: "Roboto", sans-serif;

  .buttonRegistrar {
    margin-top: 0.5rem;
    margin-bottom: 1rem;

    background-color: #1976d2;
    color: white;

    border: none;
    border-radius: 15px;

    width: 25%;
    height: 2rem;
  }


  h1 {
    margin-top: 2.5rem;
    margin-bottom: 1.2rem;
    font-size: 2.5vw;
    font-family: "roboto-medium", sans-serif;
  }

  input {
    width: 55%;
    height: 2rem;

    border-radius: 15px;
    border: 1.5px solid;
    border-color: rgba(200, 200, 200, 0.5);

    padding-left: 1.5rem;
    padding-right: 3rem;

    margin-top: 1rem;

    &:focus {
      background: rgb(231, 245, 250);
      border: 0.1px solid rgb(104, 178, 224);
      outline: none !important;
    }
  }


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


