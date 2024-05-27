import styled from 'styled-components';

export const ContainerPai = styled.div`
* {
font-size: 1vw;
font-family: "Roboto", sans-serif;
}

width: 100%;
height: 100%;
`;

export const DivMain = styled.main`
    flex: 1;
    padding: 20px;
    background-color: #f9f9f9;
`;

export const Banner = styled.div`
    img {
        width: 100%;
        height: auto;
    }
`;

export const SectionTitle = styled.section`
    text-align: center;
    margin: 20px 0;

    h1 {
        font-size: 2.5rem;
        margin-bottom: 10px;
    }

    p {
        font-size: 1.2rem;
        color: #555;
    }
`;

export const AnimalsContainer = styled.div`
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    justify-content: center;
`;

export const AnimalCard = styled.div`
    background: white;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    width: 200px;
    text-align: center;
    padding: 15px;

    img {
        width: 100%;
        height: auto;
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
