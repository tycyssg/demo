package app.config.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MODULEUSERPARAMS")
public class ModuleUserParams {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String value;
		private Integer moduleId;
		private Integer stepId;
		
		public ModuleUserParams() {}
		
		public ModuleUserParams(String value) {
			super();
			this.value = value;
		}
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}

		public Integer getModuleId() {
			return moduleId;
		}

		public void setModuleId(Integer moduleId) {
			this.moduleId = moduleId;
		}

		public Integer getStepId() {
			return stepId;
		}

		public void setStepId(Integer stepId) {
			this.stepId = stepId;
		}

		@Override
		public String toString() {
			return "ModuleUserParams [id=" + id + ", value=" + value + ", moduleId=" + moduleId + ", stepId=" + stepId
					+ "]";
		}


		
		
		
}
