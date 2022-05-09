package sufod.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("e")
public class Equipement extends Item {

		private int pv;
		private double defMagique;
		private double defPhysique;
		private double defDistance;
		private double attMagique;
		private double attPhysique;
		private double attDistance;
		private double Esquive;
		PartieCorps localisation;
		
		public Equipement() {

		}

		public Equipement(int pv, double defMagique, double defPhysique, double defDistance, double attMagique,
				double attPhysique, double attDistance, double esquive, PartieCorps localisation) {
			this.pv = pv;
			this.defMagique = defMagique;
			this.defPhysique = defPhysique;
			this.defDistance = defDistance;
			this.attMagique = attMagique;
			this.attPhysique = attPhysique;
			this.attDistance = attDistance;
			this.Esquive = esquive;
			this.localisation = localisation;
		}

		public int getPv() {
			return pv;
		}

		public void setPv(int pv) {
			this.pv = pv;
		}

		public double getDefMagique() {
			return defMagique;
		}

		public void setDefMagique(double defMagique) {
			this.defMagique = defMagique;
		}

		public double getDefPhysique() {
			return defPhysique;
		}

		public void setDefPhysique(double defPhysique) {
			this.defPhysique = defPhysique;
		}

		public double getDefDistance() {
			return defDistance;
		}

		public void setDefDistance(double defDistance) {
			this.defDistance = defDistance;
		}

		public double getAttMagique() {
			return attMagique;
		}

		public void setAttMagique(double attMagique) {
			this.attMagique = attMagique;
		}

		public double getAttPhysique() {
			return attPhysique;
		}

		public void setAttPhysique(double attPhysique) {
			this.attPhysique = attPhysique;
		}

		public double getAttDistance() {
			return attDistance;
		}

		public void setAttDistance(double attDistance) {
			this.attDistance = attDistance;
		}

		public double getEsquive() {
			return Esquive;
		}

		public void setEsquive(double esquive) {
			Esquive = esquive;
		}

		public PartieCorps getLocalisation() {
			return localisation;
		}

		public void setLocalisation(PartieCorps localisation) {
			this.localisation = localisation;
		}

	}

