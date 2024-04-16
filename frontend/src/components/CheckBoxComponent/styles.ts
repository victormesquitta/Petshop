import styled from "styled-components";

export const SaveLogin = styled.div`
  margin-top: 1.2rem;
  margin-bottom: 1.5rem;
  width: 55%;

  display: flex;

  label {
    cursor: pointer;

    input {
      margin-right: 0.5rem;
    }
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
