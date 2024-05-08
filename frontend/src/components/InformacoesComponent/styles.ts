import styled from "styled-components";

export const ContainerPai = styled.section`
height: 100%;
width: 25%;

.SectionInformacoes {
    display: flex;
    flex-direction: column;
    align-items: start;
    justify-content: start;

    border: 1.5px solid;
    border-color: #88ce08;
    border-radius: 15px;

    width: 100%;

    padding: 2rem;

    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

    height: 80%;

    h1 {
      margin-bottom: 1rem;

      color: #88ce08;

      &:hover{
        text-decoration: underline;
      }
    }

    p {
      margin-top: 1rem;

      color: #88ce08;

      cursor: pointer;

      &:hover{
        text-decoration: underline;
      }
    }

    .Links {
      margin-top: 1rem;

      text-decoration: none;

      color: #88ce08;

      &:hover{
        text-decoration: underline;
      }
    }
}
`