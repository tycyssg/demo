package app.config.dto;

public class ParamSettings {

		private String paramname;
		private String paramtype;
		
		public ParamSettings() {}
		
		public ParamSettings(String paramname, String paramtype) {
			super();
			this.paramname = paramname;
			this.paramtype = paramtype;
		}

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

		@Override
		public String toString() {
			return "ParamSettingsDb [paramname=" + paramname + ", paramtype=" + paramtype + "]";
		}
		
		
		
}
