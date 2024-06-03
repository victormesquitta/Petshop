import { InformacoesComponent } from '../../components/InformacoesComponent/InformacoesComponent';
import { NavBarLogado } from '../../components/NavBarLogado/NavBarLogadoComponent';
import { AuthService } from '../../services/AuthService';
import * as S from './styles';
import { RodapeComponent } from "../../components/RodapeComponent/RodapeComponent";

export function MeusDados(props) {
  return (
    <>
      <S.ContainerPai>
        <NavBarLogado authService={props.authService} />
        <S.ContainerMain>
          <InformacoesComponent />
          <S.DivMain>
            <h1 className="titulo">Meus Dados</h1>
            <h1 className="titulo">Meus Endereços</h1>
            <div className="form-container">
              <form>
                <label htmlFor="email">E-mail</label>
                <input type="email" id="email" name="email" placeholder="Digite seu email" />

                <label htmlFor="nome">Nome</label>
                <input type="text" id="nome" name="nome" placeholder="Digite seu nome" />

                <label htmlFor="cpf">CPF</label>
                <input type="text" id="cpf" name="cpf" placeholder="Digite seu CPF" maxLength={11} />

                <label htmlFor="celular">Celular</label>
                <input type="tel" id="celular" name="celular" placeholder="Digite seu celular" maxLength={11} />

                <button type="submit" className="btn-editar">Editar</button>
              </form>
            </div>
            <div className="form-container form-container-endereco">
              <form className='endereco'>
                <label htmlFor="estado">Estado*</label>
                <input type="text" id="estado" name="estado" className="half-width" placeholder="Digite seu estado" />

                <label htmlFor="cidade">Cidade*</label>
                <input type="text" id="cidade" name="cidade" className="half-width" placeholder="Digite sua cidade" />

                <label htmlFor="logradouro">Logradouro*</label>
                <input type="text" id="logradouro" name="logradouro" className="full-width" placeholder="Digite seu logradouro" />

                <label htmlFor="cep">CEP*</label>
                <input type="text" id="cep" name="cep" className="half-width" placeholder="Digite seu CEP" maxLength={8} />

                <label htmlFor="bairro">Bairro*</label>
                <input type="text" id="bairro" name="bairro" className="half-width" placeholder="Digite seu bairro" />

                <label htmlFor="numero">Número*</label>
                <input type="text" id="numero" name="numero" className="half-width" placeholder="Digite seu número" />

                <label htmlFor="complemento">Complemento</label>
                <input type="text" id="complemento" name="complemento" className="half-width" placeholder="Digite seu complemento" />

                <button type="submit" className="btn-editar">Editar</button>
              </form>
            </div>
          </S.DivMain>
        </S.ContainerMain>
        <RodapeComponent />
      </S.ContainerPai>
    </>
  );
}
