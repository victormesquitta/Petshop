import styled from 'styled-components';

export const ContainerPai = styled.div`
    * {
        // font-size: 3vw;
        font-family: "Roboto", sans-serif;
    }

    width: 100%;
    height: 100%;
    margin; 40px;
`;

export const DivMain = styled.main`
margin-left: 100px;
margin-right: 100px; 
`;

export const Banner = styled.div`
    img {
        max-width: 100%;
        width: 800px;
        height: auto;
        display: block;
        margin: 0 auto; /* Centraliza a imagem horizontalmente */
    }
`;

export const SectionTitle = styled.section`
    text-align: center;
    margin: 20px 0;

    h1 {
        font-size: 2em;
        margin-bottom: 10px;
    }
`;


export const AnimalCard = styled.div`
    background: white;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    text-align: center;
    padding: 15px;

    img {
        width: 100%;
        height: auto;
        border-radius: 50%;
    }

    h3 {
        margin: 10px 0;
    }

    p {
        margin: 5px 0;
        color: #777;
    }

    button {
        background: #007bff;
        color: white;
        border: none;
        padding: 10px 15px;
        border-radius: 5px;
        cursor: pointer;

        &:hover {
            background: #0056b3;
        }
    }
`;
export const TextSection = styled.section`
    padding: 20px;
    text-align: justify;
    color: #88ce08;

    h2 {
        font-size: 2rem;
        margin-bottom: 10px;
    }

    p {
        font-size: 1.3rem;
        color: #555;
        margin-top: 2em;
    }
    a {
        text-decoration: none;
        color: #88ce08;
    }
    .linha {
        font-size: 1.4vw;
        text-align: center;
        color: black;  // Cor do texto
    
        &::after {
          content: "";
          display: block;
          width: 50%;  
          height: 0.3em;
          background-color: #88ce08;  
          margin: 0 auto;
          margin-top: .5em;  
        }
`;

export const Section = styled.section`
    margin: 40px 0;
    padding: 20px;
    color: #88ce08;
    text-align: center;

    h2 {
        font-size: 1.7rem;
        // margin-bottom: 10px;
    }

 
`;
export const CarouselContainer = styled.div`
    margin: 40px auto;
    width: 75%;
    .slick-slide {
        padding: 0 10px; 
    }
    
`;

export const Promotion = styled.section`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    text-align: center;

    .promotion {
        width: 40%;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
        gap: 2em;  /* Ajuste o espaço entre as imagens conforme necessário */
        margin-left: 40px;  /* Margens laterais */
        margin-right: 40px;
        margin-top: 3em;
        margin-bottom: 3em;

        img {
            max-width: 100%;
            height: auto;
        }
    }
`;