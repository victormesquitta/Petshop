import styled from "styled-components";

export const ContainerPai = styled.div`
  width: 100%;
  height: 100%;
`;

export const ContainerMain = styled.main`
  display: flex;
  align-items: center;
  justify-content: center;

  padding: 4rem;

  height: 100%;
  width: 100%;

  div {
    width: 85%;

    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;

    h3{
      margin-top: .5rem;
    }

    .DivTitle {
      margin-bottom: 1rem;

      .MeusCartoes {
        font-size: 2vw;
        font-family: "Roboto", sans-serif;
        color: rgba(7, 57, 80, 1);
      }
      .NovoCartao {
        font-size: 1.3vw;
        margin-top: 0.5rem;
        margin-left: 0.5rem;
        font-family: "Roboto", sans-serif;
        color: rgba(7, 57, 80, 1);
      }
    }

    .DivCadastroCartao {
      width: 100%;

      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;

      border: 1px solid;
      border-color: rgba(7, 57, 80, 1);
      border-radius: 15px;

      .section {
        width: 90%;

        margin-top: 1.5rem;
        margin-left: 5rem;

        display: flex;
        align-items: center;
        justify-content: center;

        section{
          display: flex;
          flex-direction: column;
          align-items: center;
          justify-content: center;

          width: 30%;
        }

        label {
          margin-top: 2rem;
        }

        input {
          border-radius: 10px;
          border: 1px solid;
          border-color: lightgray;

          width: 80%;
          height: 2rem;

          margin-top: 0.4rem;
          padding-left: 1rem;
          padding-right: 2rem;

          display: flex;
          align-items: center;
          justify-content: center;
          
          &:focus {
            background: #f5f5f5;
            border: 0.1px solid lightgray;
            outline: none !important;
          }
        }
      }

      .Cadastro {
        border-radius: 10px;
        border-color: rgba(7, 57, 80, 1);
        background: white;

        font-size: 1rem;
      }
    }
  }

  @media screen and (max-width: 768px) {
    .box {
      width: 90%;
    }
  }
`;
