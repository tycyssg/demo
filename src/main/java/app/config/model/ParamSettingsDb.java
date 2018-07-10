package app.config.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMSETTINGSDB")
public class ParamSettingsDb implements Serializable{


		@Id
//		@GeneratedValue(strategy = GenerationType.AUTO)
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String paramname;
		private String paramtype;

		
		public String getParamname() {
			return paramname;
		}

		public void setParamname(String paramname) {
			this.paramname = paramname;
		}

		public String getParamtype() {
			return paramtype;
		}

		public void setParamtype(String paramtype) {
			this.paramtype = paramtype;
		}
		
		

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}


		@Override
		public String toString() {
			return "ParamSettingsDb [paramname=" + paramname + ", paramtype=" + paramtype + "]";
		}
		
		
		
}
