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
  width: 30%;
  height: 60%;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;

  box-sizing: border-box;

  border: 0.5px solid;
  border-color: rgba(200, 200, 200, 0.5);
  border-radius: 25px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);

  font-size: 1vw;
  font-family: "Roboto", sans-serif;

  .divEmail{
    margin-top: 1rem;
    margin-right: ;-bottom: 1rem;
  }

  .divSenha{

  }

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

