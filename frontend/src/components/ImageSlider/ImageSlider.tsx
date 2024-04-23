import 'react-slideshow-image/dist/styles.css';
import { Fade } from 'react-slideshow-image';
import ImgHomeTransition1 from '../../assets/images/ImgHomeTransition1.png';
import ImgHomeTransition2 from '../../assets/images/ImgHomeTransition2.png';
import * as S from './styles';

const slideImages = [
  {
    url: ImgHomeTransition1,
  },
  {
    url: ImgHomeTransition2,
  },
];

const ImageSlider = () => {
 
  return (
    <S.ContainerPai>
      <Fade
        arrows={false} 
        dots={true} 
      >
        {slideImages.map((image, index) => (
          <div key={index} className="image-container">
            <img src={image.url} />
          </div>
        ))}
      </Fade>
    </S.ContainerPai>
  );
};

export default ImageSlider;
