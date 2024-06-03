import { InformacoesComponent } from '../../components/InformacoesComponent/InformacoesComponent';
import { NavBarLogado } from '../../components/NavBarLogado/NavBarLogadoComponent';
import { AuthService } from '../../services/AuthService';
import ImgPerfilDog from '../../assets/images/ImgPerfilDog.png'
import * as S from './styles';
import { FaEllipsisVertical } from 'react-icons/fa6';
import { RodapeComponent } from "../../components/RodapeComponent/RodapeComponent";

export function MeusDados(props) {
    return (
        <>
            <S.ContainerPai>
                <NavBarLogado authService={props.authService} />

                <S.ContainerMain>
                    <InformacoesComponent />
                    <div className='divMain'>
                        <h1 className="titulo">Meus Dados</h1>
                        <div className="form-container">
                            <form>
                                <label htmlFor="email">E-mail</label>
                                <input type="email" id="email" name="email" placeholder="Digite seu email" />

                                <label htmlFor="nome">Nome</label>
                                <input type="text" id="nome" name="nome" placeholder="Digite seu nome" />

                                <label htmlFor="cpf">CPF</label>
                                <input type="text" id="cpf" name="cpf" placeholder="Digite seu CPF" maxLength={11}/>

                                <label htmlFor="celular">Celular</label>
                                <input type="tel" id="celular" name="celular"  placeholder="Digite seu celular" maxLength={11}/>

                                <button type="submit" className="btn-editar">Editar</button>
                            </form>
                        </div>

                        <h1 className="titulo">Meus Endereços</h1>
                        <div className="form-container">
                            <form>
                                <label htmlFor="estado">Estado*</label>
                                <input type="text" id="estado" name="estado"placeholder="Digite seu estado" />

                                <label htmlFor="cidade">Cidade*</label>
                                <input type="text" id="cidade" name="cidade"placeholder="Digite seu email" />

                                <label htmlFor="lougradouro">Logradouro*</label>
                                <input type="text" id="logradouro" name="logradouro"placeholder="Digite seu lougradouro" />

                                <label htmlFor="cep">CEP*</label>
                                <input type="text" id="cep" name="cep" placeholder="Digite seu CEP" maxLength={8}/>

                                <label htmlFor="bairro">Bairro*</label>
                                <input type="text" id="bairro" name="bairro" placeholder="Digite seu bairro"/>

                                <label htmlFor="numero">Número*</label>
                                <input type="text" id="numero" name="numero" placeholder="Digite seu número" 
                                />
                                <label htmlFor="complemento">Complemento</label>
                                <input type="text" id="complemento" name="complemento"placeholder="Digite seu complemento"     />

                                <button type="submit" className="btn-editar">Editar</button>
                            </form>
                        </div>
                    </div>
                </S.ContainerMain>
                <RodapeComponent />
            </S.ContainerPai>
        </>
    )
}
