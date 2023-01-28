package logic.completeachievement;

import logic.factory.BaseObject;

//BEAN CONTENENTE LE INFORMAZIONI RELATIVE AL COMPLETAMENTO DI UN ACHIEVEMENT
public class CompleteAchievementAchievementBean {

        //ATTRIBUTI
        private BaseObject ach;

        //METODI
        public void setBean(BaseObject ach) {
            this.ach = ach;
        }

        public BaseObject getBean() {
            return this.ach;
        }

    }
