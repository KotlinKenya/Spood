import SwiftUI
import common

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

struct ContentView: View {
    
    var body: some View {
        let authenticate: () -> Void = { print("Navigate to authentication") }
        
        ZStack{
            content( goToAuthenticate: authenticate)
            floatingButton( goToAuthenticate: authenticate)
        }
        .background(Color("yellow"))
    }
    
    
    func content(goToAuthenticate: @escaping ()  -> Void ) -> some View {
        VStack{
            Spacer()
            Button(
                action:  goToAuthenticate,
                label: { Image("logo") }
            )
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
                            .frame(width: 12, height: 12)
                            .foregroundColor(Color("grey"))
                    }
                )
                .frame(width: 56, height: 56)
                .background(Color("white"))
                .cornerRadius(28)
                .padding([.bottom, .trailing], 20)
            }
        }
    }
}
