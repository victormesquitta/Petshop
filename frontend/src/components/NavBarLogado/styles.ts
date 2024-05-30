import styled from "styled-components";

export const NavBarLogado = styled.nav`
  * {
    font-size: 1vw;
    font-family: "Roboto", sans-serif;
  }

  width: 100%;
  height: 19%;
  margin-top: 0.5rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;

  div {
    width: 100%;
    display: flex;
    align-items: center;

    img {
      height: 10vh;
      border-radius: 70px;
    }

    &:first-child {
      padding-left: 6rem;
      padding-right: 2rem;
    }

    &:last-child {
      height: 40%;
      background-color: #88ce08;
      justify-content: space-evenly;
    }

    .SectionBarraDePesquisa {
      display: flex;
      align-items: center;
      flex: 1;
      margin-left: 4rem;

      input {
        border: 1px solid #88ce08;
        border-radius: 15px;
        padding: 0 2rem 0 4rem;
        width: 100%;
        height: 2.7rem;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        &:focus {
          background: whitesmoke;
          border: 0.1px solid rgb(104, 178, 224);
          outline: none !important;
        }
      }

      .IconLupa {
        position: absolute;
        height: 1.5rem;
        width: 5%;
        color: gray;
      }
    }

    .SectionIcons {
      width: 20%;
      display: flex;
      justify-content: space-evenly;
      align-items: center;

      .IconFavoritos, .IconCarrinho {
        height: 4.5vh;
        width: 10%;
        color: #88ce08;
        cursor: pointer;
      }

      .IconFavoritos {
        margin-left: 4rem;
      }
    }

    .BotaoFimTela, .BotaoLogout, .BotaoLogin {
      border: 1px solid #88ce08;
      border-radius: 15px;
      color: #88ce08;
      background-color: white;
      box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
      display: flex;
      justify-content: center;
      align-items: center;

      .IconAdmin {
        width: 30%;
        height: 1.1rem;
        margin-right: -0.5rem;
        display: flex;
        justify-content: center;
        align-items: center;
      }
    }

    .BotaoFimTela {
      width: 12%;
      height: 2.2rem;
      margin-right: 1.5rem;
      font-size: 1vw;
    }

    .BotaoLogout, .BotaoLogin {
      width: 6%;
      height: 2.2rem;
    }

    .BotaoLogin {
      width: 7%;
    }
  }

  .DivBotoesDepartamentos {
    width: 100%;
    height: 3rem;
    display: flex;
    // flex-direction: column;
    align-items: center;
    justify-content: center;
    background-color: #4caf50;

    .Dropdown {
      width: 25%;
      height: 2.7rem;
      padding-top: 0.4rem;
      display: block;
      flex-direction: column;
      justify-content: flex-start;

      .ButtonDepartamentos {
        display: block;
        border: none;
        border-radius: 12px;
        width: 80%;
        height: 2rem;
        padding-bottom: 0.2rem;
        background-color: #073950;
        color: white;
        z-index: 1;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        cursor: pointer;

        .iconDepartamento {
          margin-right: 0.3rem;
          margin-top: 0.3rem;
        }
      }

      .dropdown-menu {
        display: none;
        flex-direction: column;
        width: 80%;
        position: relative;
        top: 0rem;
        color: #073950;
        background-color: white;
        border: none;
        border-radius: 15px;
        z-index: 0;
        cursor: pointer;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        button {
          background-color: white;
          color: #073950;
          width: 100%;
          height: 3rem;
          display: flex;
          align-items: center;
          border: none;
          border-radius: 5px;
          cursor: pointer;

          &:hover {
            box-shadow: inset 0 0 5px #073950;
          }

          img {
            width: 22%;
            height: 70%;
            margin: 0 0.5rem;
          }
        }
      }
    }
  }

  .menu {
    display: flex;
    justify-content: center;
    background-color: #4caf50;
    padding: 10px 0;

    .menu-button {
      background-color: #ffffff;
      border: 1px solid #ffffff;
      border-radius: 20px;
      padding: .4rem;
      margin: 0 10px;
      font-size: 16px;
      cursor: pointer;
      display: flex;
      align-items: center;
      gap: 10px;
      font-weight: bolder;
      color:#073950;

      &:hover {
        background-color: #e0e0e0;
      }
    }
  }

  @media (max-width: 1024px) {
    .SectionBarraDePesquisa input {
      font-size: 2vw;
    }

    .SectionIcons .IconFavoritos, .SectionIcons .IconCarrinho {
      width: 20%;
    }

    .DivBotoesDepartamentos button {
      width: 12.5%;
      height: 2rem;
      font-size: 1.6vw;

      img {
        display: none;
      }
    }

    .ButtonDepartamentos {
      padding: 0.5rem;
    }
  }
`;
