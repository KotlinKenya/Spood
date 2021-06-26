import SwiftUI

struct SpoodNavigation_Previews: PreviewProvider {
    static var previews: some View {
        SpoodNavigation()
    }
}

struct SpoodNavigation: View {
    
    var body: some View {
        NavigationView{
            SplashScreen()
        }
    }
}
