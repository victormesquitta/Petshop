import styled from "styled-components";

export const ContainerPai = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
`;

export const ContainerMain = styled.main`
display: flex;
align-items: flex-start;
padding: 4rem;
height: auto;
width: 100%;

  div {
    width: 85%;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;

    h3 {
      margin-top: 0.5rem;
    }

    .DivTitle {
      margin-bottom: 1rem;
      display:flex;
      align-items: flex-start;
      
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
      // width: 100%;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      border: 1px solid rgba(7, 57, 80, 1);
      border-radius: 15px;
      padding: 2rem;

      .section {
        width: 90%;
        margin-top: 1.5rem;
        display: flex;
        justify-content: space-between;

        section {
          display: flex;
          flex-direction: column;
          align-items: flex-start;
          width: 45%;

          label {
            margin-top: 2rem;
            font-weight: bold;
          }

          input {
            border-radius: 10px;
            border: 1px solid lightgray;
            width: 100%;
            height: 2rem;
            margin-top: 0.4rem;
            padding-left: 1rem;

            &:focus {
              background: #f5f5f5;
              border: 1px solid lightgray;
              outline: none;
            }
          }
        }
      }

      .Cadastro {
        margin-top: 2rem;
        border-radius: 10px;
        border: 1px solid rgba(7, 57, 80, 1);
        background: rgba(7, 57, 80, 1);
        color: white;
        font-size: 1rem;
        padding: 0.5rem 2rem;
        cursor: pointer;

        &:hover {
          background: rgba(7, 57, 80, 0.8);
        }
      }
    }
  }

  @media screen and (max-width: 768px) {
    padding: 2rem;

    div {
      width: 100%;

      .DivTitle {
        .MeusCartoes {
          font-size: 5vw;
        }
        .NovoCartao {
          font-size: 3vw;
        }
      }

      .DivCadastroCartao {
        padding: 1rem;

        .section {
          flex-direction: column;
          align-items: center;

          section {
            width: 100%;
            margin-bottom: 1rem;
          }
        }

        .Cadastro {
          width: 100%;
          padding: 1rem;
          font-size: 1.2rem;
        }
      }
    }
  }
`;
