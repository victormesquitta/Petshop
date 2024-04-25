import { Link } from 'react-router-dom';
import * as S from './styles';

export function InformacoesComponent() {
    return (
        <S.ContainerPai>
            <section className='SectionInformacoes'>
                <h1>Olá Victor</h1>

                <p>Dados Pessoais</p>
                <Link className="Links" to="/meuspedidos">Meus Pedidos</Link>
                <Link className="Links" to={"/favoritos"}>Favoritos</Link>
                <p>Meus Cartões</p>
                <Link className="Links" to={"/meuspets"}>Meus pets</Link>
            </section>
        </S.ContainerPai>
    );
}