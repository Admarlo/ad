using System;
using System.Data;

namespace CCategoria
{
	public class App
	{
		private IDbConnection connection;
		public App ()
		{
		}
		//Constructor statico
		//Ahora la clase ya esta iniciada
		static App (){
		}
		private static App instancce =new App();
		public static App Instance{
			get{ return instancce; }
	}
		public IDbConnection Connection{
			get{ return connection; }
			set{ connection = value; }
		}

				//formato tipo java
//		public static App instance =new App(){
//			get{return instance;}
//		}
//		public void SetConnection(IDbConnection ConnectionState){
//			this.ConnectionState=ConnectionState;
//		}
	}
}
