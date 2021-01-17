import './styles.css';
import { ReactComponent as LinkedinIcon } from './linkedin.svg';

function Footer(){
    return (
       <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className = "footer-icons">
                <a href="https://www.linkedin.com/in/ricardo-cardoso-silva-29a24a1b5/" target = "_new">
                    <LinkedinIcon />
                </a>
            </div>
       </footer>
    )
}

export default Footer;