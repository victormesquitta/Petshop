import styled from "styled-components";

export const SaveLogin = styled.div`
  width: 55%;
  height: 4%;
  margin-bottom: .5rem;

  display: flex;
  align-items: center ;

  input {
    margin-left: .5rem;
    margin-right: .7rem;
    width: 6%;
  }

  label {
    cursor: pointer;

    width: 100%;

    display: flex;
  }

  @media (max-width: 1024px) {
    margin-right: 4rem;
    margin-top: 2rem;

    label {
      font-size: 2.2vw;
    }
  }

  @media (max-width: 768px) {
    margin-right: 3.5rem;
    margin-top: 1.5rem;

    label {
      font-size: 3vw;
    }
  }

  @media (max-width: 480px) {
    margin-top: 1.5rem;
    margin-right: 1.5rem;

    label {
      font-size: 4vw;
    }
  }
`;
