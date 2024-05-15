import styled from "styled-components";

export const InputSenha = styled.form`
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 1rem;
  width: 100%;

  input {
    width: 55%;
    height: 6vh;

    border-radius: 15px;
    border: 1.5px solid;
    border-color: rgba(200, 200, 200, 0.5);

    padding-left: 1.5rem;
    padding-right: 3rem;

    &:focus {
      background: whitesmoke;
      border: 0.1px solid rgb(104, 178, 224);
      outline: none !important;
    }
  }

  .divOlhoAbertoOuFechado {
    width: 100%;

    margin-left: 1.1rem;
    display: flex;
    justify-content: center;

    .OlhoAbertoOuFechado {
      position: relative;

      right: 3rem;
      top: .5rem;
    }
  }

  .divButton {
    display: flex;
    position: relative;
    justify-content: center;

    width: 100%;

    button {
      background-color: #1976d2;
      color: white;

      border: none;
      border-radius: 15px;

      width: 25%;
      height: 2rem;
    }
  }

  .Links {
    margin-top: 0.5rem;
    margin-bottom: 1rem;    

    text-decoration: none;
    

    &:hover{
      text-decoration: underline;
    }
  }

  .ErroMessage {
    width: 100%;
    background-color: red;
  }

  .RecuperaSenha{
    position: sticky;
  }

  @media (max-width: 1024px) {
    gap: 2rem;

    input {
      width: 70%;
      height: 3.5rem;

      font-size: 2.3vw;
    }

    .divButton {      
      button {
        font-size: 2.2vw;
        
      }
    }
    @media (max-width: 1032px) {
      .Links {
        font-size: 2vw;
      }
    }
  }

  @media (max-width: 768px) {
    gap: 2rem;

    input {
      width: 70%;
      height: 3.8rem;

      font-size: 3vw;
    }

    .divButton {
      button {
        font-size: 3vw;
      }
    }
  }

  @media (max-width: 480px) {
    gap: 2rem;

    input {
      width: 70%;
      height: 3rem;

      font-size: 3.5vw;
    }

    .divButton {
      button {
        font-size: 4vw;
      }
    }
  }
`;
