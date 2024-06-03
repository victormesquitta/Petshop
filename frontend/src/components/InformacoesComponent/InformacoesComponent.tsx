import { Link } from 'react-router-dom';
import * as S from './styles';

export function InformacoesComponent() {
    return (
        <S.ContainerPai>
            <section className='SectionInformacoes'>
                <h1>Olá Victor</h1>

                <Link className="Links" to="/meusdados">Dados Pessoais</Link>
                <Link className="Links" to="/meuspedidos">Meus Pedidos</Link>
                <Link className="Links" to={"/favoritos"}>Favoritos</Link>
                <Link className="Links" to={"/meuscartoes"}>Meus Cartões</Link>
                <Link className="Links" to={"/meuspets"}>Meus pets</Link>
            </section>
        </S.ContainerPai>
    );
}