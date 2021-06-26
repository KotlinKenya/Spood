import SwiftUI
import common

struct SplashScreen_Previews: PreviewProvider {
    static var previews: some View {
        SplashScreen()
    }
}

struct SplashScreen: View {
    
    @State private var clickedSignUpLink = false
    
    var body: some View {
        
        let authenticate: () -> Void = { self.clickedSignUpLink = true }
        
        ZStack{
            NavigationLink( destination: SignUp(), isActive: $clickedSignUpLink ){ EmptyView() }
            content( goToAuthenticate: authenticate)
            floatingButton( goToAuthenticate: authenticate)
        }
        .background(Color("yellow"))
        .navigationBarHidden(true)
    }
    
    
    func content(goToAuthenticate: @escaping ()  -> Void ) -> some View {
        VStack{
            Spacer()
            Button( action:  goToAuthenticate, label: { Image("logo") } )
            Spacer()
            Image("banner")
            Spacer()
            Image("tagline")
            Spacer()
        }
    }
    
    func floatingButton(goToAuthenticate: @escaping ()  -> Void ) ->  some View {
        VStack {
            Spacer()
            HStack {
                Spacer()
                Button(
                    action: goToAuthenticate,
                    label: {
                        Image("ic_arrow_right")
                            .frame(width: 56, height: 56)
                            .background(Color("white"))
                            .cornerRadius(28)
                    }
                )
                .padding()
                .shadow(color: .black.opacity(0.3), radius: 3, x: 3, y: 3)
            }
        }
    }
}
